var app=angular.module('studentRecord',[]);

app.controller('listdata', function($scope){

	$scope.users=[
	{"id":1,"first_name":"vivek","last_name":"tiwari","hobby":"game"},
	{"id":2,"first_name":"aman","last_name":"chaurasia","hobby":"talking"},
	{"id":3,"first_name":"alok","last_name":"singh","hobby":"singing"},
	{"id":4,"first_name":"vinay","last_name":"giri","hobby":"playing"},
	{"id":5,"first_name":"rishabh","last_name":"tiwari","hobby":"newser"},
	{"id":6,"first_name":"ankur","last_name":"pandey","hobby":"watching"},
	{"id":7,"first_name":"vipendra","last_name":"marawade","hobby":"sleeping"},
	{"id":8,"first_name":"indrapal","last_name":"yadav","hobby":"gim"},
	{"id":9,"first_name":"vibhav","last_name":"mishra","hobby":"reading"},
	{"id":10,"first_name":"harsit","last_name":"jain","hobby":"drinking"},
	{"id":11,"first_name":"naresh","last_name":"garg","hobby":"solver"},
	{"id":12,"first_name":"sivam","last_name":"shukla","hobby":"thinker"},
	{"id":13,"first_name":"manish","last_name":"guru","hobby":"dancing"},
	{"id":14,"first_name":"ashok","last_name":"sagar","hobby":"biking"}
]
});