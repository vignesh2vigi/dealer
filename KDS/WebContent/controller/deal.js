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
		$scope.error=response.data
	console.log(response.status)
    	 $location.path('/login')
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

		
	$scope.sortData=function(Dealername){	
		$scope.reverseSort=($scope.sortColumn==Dealername)? !$scope.reverseSort:false;
		$scope.sortColumn=Dealername;
	}
	
	$scope.getsortClass=function(Dealername){	
		if($scope.sortColumn==Dealername){
			 return $scope.reverseSort ? 'arrow-down':'arrow-up';
			
		}
		return '';
	}

	
	getlist()
	list()
	deallist()
})