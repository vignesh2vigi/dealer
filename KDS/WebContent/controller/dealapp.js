/**
 * 
 */
app.controller('DealerAppController',function($scope,DealerService,$location,$rootScope,$cookieStore,$routeParams){
	var dealer_mobile=$routeParams.dealer_mobile
	DealerService.ape(dealer_mobile).then(function(response){
		$scope.loan=response.data
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	
	$scope.loanlimit=function(loan){		
		console.log("hi===="+$scope.loan.loanlimit)
		DealerService.loanlimit($scope.loan).then(function(response){
			console.log("hiiiiiiiiii===="+$scope.currentDealer.admin_id)
			console.log(response.data)
			console.log(response.status)
			alert('Updated successfully')
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


	$scope.reject=function(loan){	
		console.log("hi===="+$scope.loan)
		DealerService.reject($scope.loan).then(function(response){
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
	
})
