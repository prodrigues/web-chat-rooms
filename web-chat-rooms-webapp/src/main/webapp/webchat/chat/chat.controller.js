(function(webchatModule) {
  'use strict';
  
  var ChatController = function(ChatService) {
    var _that = this;
    this.ChatService = ChatService;
    this.messages = [];
    this.newMessage = '';

    this.ChatService.receiveMessage().then(null, null, function(message) {
      _that.messages.push(message);
    });
    
  };

  ChatController.prototype.sendMessage = function(message) {
    if(message.trim().length === 0) {
      return;
    }
    
    this.ChatService.sendMessage({
      creationDate: new Date(),
      fromUser: this.messages.length % 2 === 0,
      text: message
    });
    this.newMessage = '';
  };
  
  ChatController.$inject = ['ChatService'];
  webchatModule.controller('ChatController', ChatController);
})(angular.module('webchat'));