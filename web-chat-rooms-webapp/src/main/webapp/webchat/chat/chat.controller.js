(function(webchatModule) {
  'use strict';
  
  var ChatController = function() {
    this.messages = [];
    this.newMessage = '';
    
  };

  ChatController.prototype.sendMessage = function(message) {
    this.messages.push({
      text: message,
      creationDate: new Date()
    });
    this.newMessage = '';
  };
  
  ChatController.$inject = [];
  webchatModule.controller('ChatController', ChatController);
})(angular.module('webchat'));