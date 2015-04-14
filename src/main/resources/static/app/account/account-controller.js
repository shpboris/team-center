angular.module('account', [])
  .controller('accountController', ['$scope', '$http', function($scope, $http) {   
	  $scope.newUser = {};
	  $scope.createAccount = function(){
		    $http.post('../../users',$scope.newUser)
		    .success(function(data, status, headers, config){
		    	window.location.href = 'welcome-new-account.html';
		    })
		    .error(function(data, status, headers, config){
		        alert('Error creating user \n'+data.message);
		    });
		};
}])