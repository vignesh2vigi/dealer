/**
 * 
 */
app.factory('DealerService',function($http){
	var dealerService={}
	var BASE_URL="http://localhost:8080/KDS"
	
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
	dealerService.ape=function(dealer_mobile)
	{
	return $http.get(BASE_URL+"/servlet/approve/"+dealer_mobile)
	}
	
	
	dealerService.regDetailsList=function()
	{
	return $http.get(BASE_URL+"/servlet/dealershiplist")
	}
	
	dealerService.accept=function(accept){
		return $http.post(BASE_URL +"/servlet/active",accept)
	}
	
	dealerService.register=function(register){
		return $http.post(BASE_URL +"/servlet/dealerRegistration",register)
	}
	return dealerService;
	
})