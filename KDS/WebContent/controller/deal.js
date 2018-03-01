/**
 * 
 */
app.controller('DealerController',function($scope,DealerService,$location,$rootScope,$cookieStore){

	
	$scope.login=function(){
		console.log($scope.log)
		DealerService.login($scope.log).then(function(response){
		console.log(response.data)
		console.log(response.status)
		$rootScope.currentDealer=response.data //username
		$cookieStore.put('currentDealer',response.data)
		$location.path('/dealerlist')
		
	},function(response){
		console.log(response.data)
		console.log(response.status)
    	if(response.status==415){
    		/*$scope.error=response.data*/
			$location.path('/login')
		}
    	else if(response.status==401){
    		/*$scope.error=response.data*/
			$location.path('/login')
		}
	})
	}

	function getlist() {
		DealerService.getlist().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			$scope.deal = response.data
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	function list() {
		DealerService.list().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			$scope.ape = response.data
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	function deallist() {
		DealerService.deallist().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			$scope.rjt = response.data
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	
	$scope.loanlimit=function(loan){	
		console.log("hi===="+$scope.loan)
		DealerService.loanlimit($scope.loan).then(function(response){
			console.log(response.data)
			console.log(response.status)
			alert('Updated successfully')
			$location.path('/dealerlist')
		},function(response){
			if(response.status==401){
				$location.path('/dealerlist')
			}
			else{
				/*$scope.error=response.data*/
				$location.path('/dealerlist')
				}			
			console.log(response.data)
			console.log(response.status)
	})
		}
	
	
	getlist()
	list()
	deallist()
})