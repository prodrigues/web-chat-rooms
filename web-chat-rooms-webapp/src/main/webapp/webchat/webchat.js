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

		$stateProvider.state(signinState);

		// default routes?missing, error pages, stuff like that?
	} ]);
})(angular);