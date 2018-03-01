/**
 * 
 */
var app = angular.module("app", [ 'ngRoute','ngCookies'])
app.config(function($routeProvider) {

	$routeProvider
	.when("/login", {
        templateUrl : 'log.html',
        controller:'DealerController'
       
        })
   .when("/dealerlist", {
        templateUrl : 'dealer.html',
        controller :'DealerController'	
        })
        .when("/approvelist", {
        templateUrl : 'approvelist.html',
        controller :'DealerController'	
        })
        .when("/rejectlist", {
        templateUrl : 'rejectlist.html',
        controller :'DealerController'	
        })
        .when('/approve/:dealer_mobile', {
		templateUrl : 'approve.html', controller:'DealerAppController'
	})
        .when('/reject/:dealer_mobile', {
		templateUrl : 'rej.html', controller:'DealerAppController'
	})
        
    .otherwise("/login",{templateurl:"log.html",controller:'DealerController'})
   	
})

app.run(function($rootScope,$cookieStore,$location,DealerService){
	
		if($rootScope.currentDealer==undefined){
			$rootScope.currentDealer=$cookieStore.get('currentDealer')
		}
		$rootScope.logout=function(){
			
			DealerService.logout().then(function(response){
			delete $rootScope.currentDealer;
			console.log(response.status)
			console.log(response.data)
			$cookieStore.remove('currentDealer')
			$location.path('/login')
			
		},function(response){
			if(response.status==401){
				console.log(response.status)
				console.log(response.data)
				delete $rootScope.currentDealer;
				$cookieStore.remove('currentDealer')
				$location.path('/login')

			}
				
		})
	}

})
