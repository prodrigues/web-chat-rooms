(function(webchatModule) {
  'use strict';
  
  var SignInController = function($scope) {
    var that = this;
    this.scope = $scope;
    
    this.scope.form = {};
    this.scope.joinApp = function() {that.joinApp();};
  };

  SignInController.prototype.joinApp = function() {
    this.scope.form.name += ' !!!';
  };
  
  SignInController.$inject = ['$scope'];
  webchatModule.controller('SignInController', SignInController);
})(angular.module('webchat'));