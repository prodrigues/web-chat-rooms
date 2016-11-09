(function(webchatModule) {
  'use strict';
  
  var ChatController = function() {
    this.messages = [];
    this.newMessage = '';
    
  };

  ChatController.prototype.sendMessage = function(message) {
    if(message.trim().length === 0) {
      return;
    }

    this.messages.push({
      creationDate: new Date(),
      fromUser: this.messages.length % 2 === 0,
      text: message
    });
    this.newMessage = '';
  };
  
  ChatController.$inject = [];
  webchatModule.controller('ChatController', ChatController);
})(angular.module('webchat'));