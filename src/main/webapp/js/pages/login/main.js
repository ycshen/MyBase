define(function(require, exports, module) {
	require("bootstrap");
	require("jquery.unobtrusive");
	//seajs.use(["pages/login/style.css" ], function() {
		if (top.location != location) {
			top.location.href = location.href;
		}
		$(function(){
		})
	//});

	// 通过 exports 对外提供接口
	// exports.doSomething = ...

	// 或者通过 module.exports 提供整个接口
	// module.exports = ...

});