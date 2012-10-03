//冰迪
$(function(){
	 //set template and process
    $("#Items").setTemplateElement("Template-Items").processTemplateURL($("#paralisturl").attr("value"));
});

function parameterSavePost(data){
	$.ajax({
		   type: "POST",
		   url: $("#parasaveurl").attr("value"),
		   data: data,
		   success: function(msg){
		     alert( "Data Saved: " + msg );
		   }
		});
}