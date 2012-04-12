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
     return cordova.exec(successCallback, errorCallback, "Unplugg", "addSchedule", [schedule]);
};

/**
 * Add a new schedule to turn off services
 * 
 * @param {Object} schedule
 * @param {Object} successCallback
 * @param {Object} errorCallback
 */
Unplugg.prototype.toggleAirplaneMode = function(enabled, successCallback, errorCallback) {
     return cordova.exec(successCallback, errorCallback, "Unplugg", "toggleAirplaneMode", [enabled]);
};

/**
 * Load Unplugg interface
 */
cordova.addConstructor(function() {
    cordova.addPlugin("unplugg", new Unplugg());
});
