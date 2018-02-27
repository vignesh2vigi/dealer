/**
 * 
 */
app.factory('DealerService',function($http){
	var dealerService={}
	var BASE_URL="http://localhost:9080/KDS"
	
		dealerService.getlist=function()
	{
	return $http.get(BASE_URL+"/servlet/dealerlist3")
	}

	dealerService.loanlimit=function(loan)
	{
	return $http.put(BASE_URL+"/servlet/loanlimit",loan)
	}
	dealerService.reject=function(loan)
	{
	return $http.put(BASE_URL+"/servlet/reject",loan)
	}
	dealerService.login=function(log)
	{
	return $http.post(BASE_URL+"/servlet/login",log)
	}
	dealerService.logout=function()
	{
	return $http.get(BASE_URL+"/servlet/logout")
	}
	dealerService.ape=function(dealer_name)
	{
	return $http.get(BASE_URL+"/servlet/approve/"+dealer_name)
	}
	return dealerService;
	
})