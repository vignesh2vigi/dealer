/**
 * 
 */
app.controller('DealerAppController',function($scope,DealerService,$location,$rootScope,$cookieStore,$routeParams){
	
	var dealer_mobile=$routeParams.dealer_mobile
	DealerService.ape(dealer_mobile).then(function(response){
		
		$scope.loan=response.data
		console.log("type===="+$scope.loan.dealer_mobile)
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
			
	$scope.loanlimit=function(loan){	
		console.log("loanLimit===="+$scope.loan.loanlimit)

	DealerService.loanlimit($scope.loan).then(function(response){
	console.log(response.data)		
			console.log(response.status)
		
			$location.path('/dealerlist')
		}
		
	,function(response){
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
	
	$scope.edit=function(loan){	
		console.log("edit===="+$scope.loan.sno)

	DealerService.edit($scope.loan).then(function(response){
	console.log(response.data)		
			console.log(response.status)
		
			$location.path('/dealerlist')
		}
		
	,function(response){
			if(response.status==401){
				$location.path('/login')
			}
			else{
				/*$scope.error=response.data*/
				$location.path('/edit')
				}			
			console.log(response.data)
			console.log(response.status)
	})
	
		}
	


	$scope.reject=function(loan){	
		console.log("hi===="+$scope.selectedItem)
	
	DealerService.reject($scope.loan).then(function(response){
			console.log(response.data)
			console.log(response.status)
			/*alert('Updated successfully')*/
			
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
	getlist()
})
