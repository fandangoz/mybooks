/*
 *	Depends:
 *	jquery.ui.core.js
 *	jquery.ui.widget.js
 */
$.widget('mybooks.myBooksList', {
	version : '0.0.1',
	options : {
		htmlTemplate : '/mybooks/resources/html/books_table.html',
		getAllBooksService : 'books/getAllBooks',
		closeCallback: null
	},
	_create : function() {
		var self = this, opts = self.options, el = self.element;
		self._createBooksList(el);
	},
	_createBooksList : function(el) {
		var self = this, opts = self.options, el = self.element;
		
		el.addClass('center')
		
		el.load(opts.htmlTemplate, function() {
			self._fillBooksList(el.find("#booksTable"));
			self._handleAddBookButtonClick(el.find('#add_book'));
		});
	},
	_fillBooksList : function(table) {
		var self = this, opts = self.options, el = self.element;
		table.DataTable({
			"ajax" : {
				"url" : opts.getAllBooksService,
				"dataSrc" : ""
			},
			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "title"
			}, {
				"data" : "author"
			}, {
				"data" : "isbn"
			} ]
		});
	},
	_handleAddBookButtonClick : function(button) {
		var self = this, opts = self.options, el = self.element;
		button.click(function(){
			opts.closeCallback();
		});
	},
	getOption : function(key) {
		console.info(this.widgetName + '.getOption');
		var self = this, opts = self.options;

		return opts[key];
	},
	_setOption : function(key, value) {
		console.info(this.widgetName + '._setOption');
		var self = this, opts = self.options;
	},
	_init : function() {
		var self = this, opts = self.options;
	},
	refresh : function() {
		console.info(this.widgetName + '._refresh');
		var self = this, opts = self.options;
	},
	destroy : function() {
		console.info(this.widgetName + '.destroy');
		var self = this, opts = self.options, el = self.element;
		$.Widget.prototype.destroy.call(this);
	}
});
