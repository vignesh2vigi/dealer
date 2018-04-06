/**
 * 
 */
app.controller('DealerController',function($scope,DealerService,$location,$rootScope,$cookieStore,$interval){

	
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
			$scope.items = 3;
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	function regDetailsList() {
		DealerService.regDetailsList().then(function(response) {
			//
			console.log("data-------------->"+response.data.respObj.regDetailsList);
	
			$scope.dealer = response.data.respObj.regDetailsList;
			
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	
	$scope.accept=function(deal){
		console.log("id"+deal.userid)
		console.log("name"+deal.name)
		
		DealerService.accept({"userid":deal.userid,"active_status":"1"}).then(function(response){
			
			$location.path('/dealerlist')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			else
			console.log(response.status)
			
		})
		
			DealerService.register({"userid":deal.userid,"name":deal.name,"mobile_no":deal.mobile_no,"active_status":"1","email_id":deal.email_id,
				"image":deal.image,"dealership_name":deal.dealership_name,"pincode":deal.pincode,"district":deal.district,"pan_no":deal.pan_no,"state":deal.state,"dealership_type":deal.dealership_type,
				"login_type":deal.login_type,"active_status":"1","geo_address":deal.geo_address,"post":deal.post}).then(function(response){
			
			$location.path('/entrydealerlist')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			else
			console.log(response.status)
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
	$scope.current_title = 'www.kuwy.in/';
    $scope.current_description = 'www.kuwy.in/';
    
	$scope.ptime = new Date().toLocaleTimeString();
	$interval(function () {
	$scope.ptime = new Date().toLocaleTimeString();
	}, 1000)
	
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

	regDetailsList()
	getlist()
	list()
	deallist()
})