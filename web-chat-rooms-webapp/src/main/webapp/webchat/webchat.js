(function(angular) {
	'use strict';
	
	var app = angular.module('webchat', [ 
		'ui.router'
	]);

	app.config([ '$stateProvider', function($stateProvider) {

		var signinState = {
			name: 'signin',
			url: '',
			templateUrl: 'webchat/signin/signin.html',
			controller: 'SignInController'
		};	

		var chatState = {
			name: 'chat',
			url: '',
			templateUrl: 'webchat/chat/chat.html',
			controller: 'ChatController',
			controllerAs: 'chatCtrl'
		};

		//$stateProvider.state(signinState);
		$stateProvider.state(chatState);

		// default routes?missing, error pages, stuff like that?
	} ]);
})(angular);