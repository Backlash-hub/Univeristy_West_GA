    /**
 * Script to process the submitted form data of the form in file
 * artsdealer.html
 */

/**
 * Sets the value of the hidden form field to a string with the formatted
 * submitted form data. If invalid form data is submitted, the hidden form
 * field value is set to an empty string. Form fields have to meet the
 * following criteria:
 * title: must be an non-empty string
 * artist: must be an non-empty string
 * year: must be a postiive integer value or empty
 * price: must be a non-negative value
 * description: any string, possibly an empty string
 *
 * @returns {boolean} true
 */
function prepareSummary() {

    let artwork = {
        title: document.forms[0].title.value,
        artist: document.forms[0].artist.value,
        year: document.forms[0].year.value,
        price: document.forms[0].price.value,
        description: document.forms[0].description.value,
    }
    if (validateAndParseArtworkData(artwork)) {
        document.forms[0].summary.value = formatSummary(artwork) ;
     } else {
        document.forms[0].summary.value = "";
    }
    return true;
}

/**
 * Validates the submitted object properties. Properties have to meet the
 * following criteria:
 *  artwork.title: must be an non-empty string
 *  artwork.artist: must be an non-empty string
 *  artwork.year: must be an empty string or represent a non-negative integer
 *  artwork.price: must be a non-negative value
 * The price and year property are set to the number they represent. If
 * artwork.year is an empty string, artwork.year is set to the value NaN.
 *
 * @param {object} artwork the object containing the submitted artwork data
 * @param {string} artwork.title the title of the artwork
 * @param {string} artwork.artist the name of the artist
 * @param {string} artwork.year the year the artwork was created
 * @param {string} artwork.price the sales price
 * @param {string} artwork.description the description of the artwork
 * @returns {boolean} false if invalid data is submitted; otherwise,
 * returns true
 */
function validateAndParseArtworkData(artwork) {
    if (artwork.title == "") {
        return false;
    }
    if (artwork.artist == "") {
        return false;
    }
    if (artwork.year == "") {
        artwork.year = NaN;
        } else {
            artwork.year = Number.parseInt(artwork.year);
            if (Number.isNaN(artwork.year) || artwork.year < 0) {
                return false;
            }
        }

    if (artwork.price == "") {
        return false;
    }
    artwork.price = Number.parseFloat(artwork.price);
    if (Number.isNaN(artwork.price) || artwork.price < 0) {
        return false;
    }
    return true;
}



/**
 * Format the data in object for dislpay in an HTML document. The formatted
 * string has to be of the following form:
 *   {artwork.title}<br>by {artwork.artist}<br>[Year: {artwork.year}<br>]
 *   Price: {artwork.price}<br>[Description: {artwork.description}]
 * where
 *   {artwork.title} is the string artwork.title in uppercase letters
 *   {artwork.artist} is the name of the artist
 *   {artwork.price} is the value of artwork.price with two decimal digits
 *             after the decimal point.
 *   {artwork.description} is the content of artwork.description
 * The brackets [] indicated that the included part should be omitted in case
 * artwork.year is not a number, repectively, if artwork.description is an
 * empty string.
 *
 * @param {object} artwork the object containing the submitted artwork data
 * @param {string} artwork.title the title of the artwork
 * @param {string} artwork.artist the name of the artist
 * @param {number} artwork.year the year the artwork was created
 * @param {number} artwork.price the sales price
 * @param {string} artwork.description the description of the artwork
 * @returns {string} the formatted string
 */
function formatSummary(artwork) {
    let feedback = artwork.title.toUpperCase() + "<br>";
    feedback += "by " + artwork.artist.charAt(0).toUpperCase();
    feedback += artwork.artist.substring(1, artwork.artist.length).toLocaleLowerCase() + "<br>";
    if (!Number.isNaN(artwork.year)) {
        feedback += "Year: " + artwork.year + "<br>";
    }
    if (!Number.isNaN(artwork.price)) {
        feedback += "Price: $" + artwork.price.toFixed(2) + "<br>";
    }
    let description = artwork.description;
    if (description != "") {
        feedback += "Description: "
        if (description.length > 100) {
            description = description.substring(0, 97) + "...";
        }
        feedback += description;
    }
    return feedback;
}