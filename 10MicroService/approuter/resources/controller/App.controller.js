sap.ui.define(
		["sap/ui/core/mvc/Controller"],
		function(Controller){
	return Controller.extend("anubhav.controller.App",{
		onInit: function(){
			debugger;
			var oDataModel = new sap.ui.model.odata.v2.ODataModel("/java/anubhav.svc");
			this.getView().setModel(oDataModel);
		}
	});
});