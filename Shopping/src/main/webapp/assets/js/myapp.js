
$(function(){
	// solving active menu problem
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
		if(menu="Home") break;
		$('#listProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	
	}
	
	// code for jquery datatable
	
	var $table=$('#productListTable');
	
	// execute the code only when we have this table
	if($table.length){
// console.log('Inside the table');
		var jsonUrl='';
		if(window.categoryId==''){
			jsonUrl=window.contextRoot+'/json/data/all/products';
			console.log('Hi');
		}
		else{
			jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		$table.DataTable({
			lengthMenu:[[3,5,-1],['3 Records','5 Records','ALL']],
			pageLength:5,
			ajax : {
				url:jsonUrl,
			   dataSrc: ''   // it is a collection of object without any name
			},	
			columns:[      // collection of object
				  {
					data:'code',
					mRender=function(data,type,row){
					return '<img src="'+window.ContextRoot+'/resources/images/'+data+'.jpg"  class="dataTableImg"/>';
					}
				},
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data :'unitPrice',
			        mRender: function(data,type,row){
			        	return '$#8377; '+data
			        }
				},
				{
					data :'qunatity'
				},
				{
					data :'id',
					bSortable='false',
					 mRender: function(data,type,row){
				        	var str='';
				        	str +='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
				        	str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-eye-open"></span></a>';
				        	return str;
				        }
				}
			]
		});
	}
	
});