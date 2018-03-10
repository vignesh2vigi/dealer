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
	dealerService.list=function()
	{
	return $http.get(BASE_URL+"/servlet/dealerlistave")
	}
	dealerService.deallist=function()
	{
	return $http.get(BASE_URL+"/servlet/dealerlistrjt")
	}

	dealerService.loanlimit=function(loan)
	{
	return $http.post(BASE_URL+"/servlet/loanlimit",loan)
	}
	dealerService.edit=function(edit)
	{
	return $http.post(BASE_URL+"/servlet/edit",edit)
	}

	dealerService.reject=function(loan)
	{
	return $http.post(BASE_URL+"/servlet/reject",loan)
	}
	dealerService.login=function(log)
	{
	return $http.post(BASE_URL+"/servlet/login",log)
	}
	dealerService.logout=function()
	{
	return $http.get(BASE_URL+"/servlet/logout")
	}
	dealerService.ape=function(sno)
	{
	return $http.get(BASE_URL+"/servlet/approve/"+sno)
	}
	
	return dealerService;
	
})