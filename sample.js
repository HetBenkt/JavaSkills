print('Hello world!');

var fun1 = function(name) {
	print('Hi from JS ' + name);
	return "Greetz from JS";
};

var fun2 = function(object) {
	print('JS Class Definition: ' + Object.prototype.toString.call(object));
};