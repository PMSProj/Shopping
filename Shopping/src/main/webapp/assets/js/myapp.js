
$(function(){
	//solving active menu problem
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	
		
	default:
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	
	}
	
	//code for jquery datatable
	//create  a dataset
	var products=[
		       
		         ['1','ABC'],
		         ['2','CUY'],
		         ['3','WWW'],
		         ['4','Rwe'],
		         ['5','rfe'],
		         ['6','wee'],
		         ['7','qwe'],
		         ['8','uuig'],
		         ['9','Auk'],
		         ['10','fdh']
	
		
	];
	var $table=$('#productListTable');
	
	//execute the code only when we have this table
	if($table.length){
//		console.log('Inside the table');	
		
		$table.DataTable({
			lengthMenu:[[3,5,-1],['3 Records','5 Records','ALL']],
			pageLength:5,
			data:products	
			
		});
	}
	
});