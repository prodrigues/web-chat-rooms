(function(componentsModule) {
  'use strict';
  
  var CapitalizeFilter = function() {
    return function(input) {
      return input ? input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase() : '';
    };
  };

  componentsModule.filter('capitalize', CapitalizeFilter);  
})(angular.module('ext.components'));