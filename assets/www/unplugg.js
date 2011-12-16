/**
 * Constructor
 */
function Unplugg() {
}

/**
 * Add a new schedule to turn off services
 * 
 * @param {Object} schedule
 * @param {Object} successCallback
 * @param {Object} errorCallback
 */
Unplugg.prototype.addSchedule = function(schedule, successCallback, errorCallback) {
     return PhoneGap.exec(successCallback, errorCallback, "Unplugg", "addSchedule", [schedule]);
};

/**
 * Load Unplugg interface
 */
PhoneGap.addConstructor(function() {
    PhoneGap.addPlugin("unplugg", new Unplugg());
});
