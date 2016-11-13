(function(webchatModule, SockJS, Stomp, JSON, undefined) {
  'use strict';

  var RECONNECT_TIMEOUT = 30000;
  var SOCKET_URL = '/chatrooms/api/chat';
  var CHAT_TOPIC = '/topic/message';
  var CHAT_BROKER = '/app/chat';

  var ChatService = function($q, $timeout) {
    this.$q = $q;
    this.$timeout = $timeout;
    this.listener = this.$q.defer();
    this.socket = {
      client: null,
      stomp: null
    };

    this.initialize();
  };

  ChatService.prototype.reconnect = function() {
    var _that = this;
    this.$timeout(function() {
      _that.initialize();
    }, RECONNECT_TIMEOUT);
  };

  ChatService.prototype.initialize = function() {
    var _that = this;
    this.socket.client = new SockJS(SOCKET_URL);
    this.socket.stomp = Stomp.over(this.socket.client);
    this.socket.stomp.connect({}, function() {_startListener.call(_that);});
    this.socket.stomp.onclose = function() {_that.reconnect();};
  };

  ChatService.prototype.receiveMessage = function() {
    return this.listener.promise;
  };

  ChatService.prototype.sendMessage = function(message) {
    var creationDate = message.creationDate;
    if(typeof creationDate === 'undefined') {
      creationDate = new Date().toISOString();
    } else if(Object.prototype.toString.call(creationDate) === '[object Date]') {
      creationDate = creationDate.toISOString();
    }

    var data = {
      creationDate: creationDate,
      text: message.text,
      author: message.author
    };

    var stompOpts = {
      priority: 9
    };

    this.socket.stomp.send(CHAT_BROKER, stompOpts, JSON.stringify(data));
  };

  var _startListener = function() {
    var _that = this;
    this.socket.stomp.subscribe(CHAT_TOPIC, function(data) {
      _that.listener.notify(_getMessage.call(_that, data.body));
    });
  };

  var _getMessage = function(data) {
    return JSON.parse(data);
  };

  ChatService.$inject = ['$q', '$timeout'];
  webchatModule.service('ChatService', ChatService);

})(angular.module('webchat'), SockJS, Stomp, JSON);