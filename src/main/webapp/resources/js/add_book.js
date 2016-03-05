/*
 *	Depends:
 *	jquery.ui.core.js
 *	jquery.ui.widget.js
 */
$.widget('mybooks.addBook', $.ui.dialog, {
	version : '0.0.1',
	options : {
		htmlTemplate : '/mybooks/resources/html/book_form.html',
		addBookService : 'books/addBook',
		closeCallback : null,
		authorRegrex : /A\w*/,
		authorNotValidMessage : 'Author Forename or Surname must start with "A" letter'
	},
	_create : function() {
		var self = this, opts = self.options, el = self.element;
		self._createBookForm();
	},
	_createBookForm : function() {
		var self = this, opts = self.options, el = self.element;
		el.addClass('center')
		el.load(opts.htmlTemplate, function() {
		
			self._handleAddButtonClick();
			self._handleShowBooksListClick();
		});
	},
	_handleAddButtonClick : function() {
		var self = this, opts = self.options, el = self.element;
		$('#add_book_button').click(function( e ) {
			e.preventDefault();
			self._removeErrors();
			var fields = self._getFields();
			if(self._validateFields(fields) === true) {
				self._createBook(fields);
			}
		});
	},
	_handleShowBooksListClick : function() {
		var self = this, opts = self.options, el = self.element;
		$('#show_books_list_button').click(function() {
			e.preventDefault();
			self._showBooksList();
		});
	},
	_getFields : function(){
		var self = this, opts = self.options, el = self.element;
		var author = $('#author').val();
		var title = $('#title').val();
		var isbn = $('#isbn').val();
		var fields = {
			"author" : author,
			"title" : title,
			"isbn" : isbn
		};
		return fields;
	},
	_showBooksList : function (){
		var self = this, opts = self.options, el = self.element
		opts.closeCallback();
	},
	_removeErrors : function() {
		var self = this, opts = self.options, el = self.element
		var validationParagraph = $("#validation_messages");
		validationParagraph.text('');
		var errorFields = $(".ui-state-error");
		for (i = 0; i < errorFields.length; i++) { 
			$(errorFields[i]).removeClass("ui-state-error");
		}
	},
	_validateFields : function(fields){
		var self = this, opts = self.options, el = self.element;
		
		if(opts.authorRegrex.test(fields.author) === false) {
			$('#author').addClass('ui-state-error');
			var validationParagraph = $("#validation_messages");
			validationParagraph.addClass('ui-state-error');
			validationParagraph.text(opts.authorNotValidMessage);
			return false;
		}
		return true;		
	},
	_createBook : function(fields) {
		var self = this, opts = self.options, el = self.element
		$.ajax({
		    type: "POST",
		    url: opts.addBookService,
		    data: JSON.stringify(fields),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: self._showBooksList()

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
		// console.info( this.widgetName + '._init' );
		var self = this, opts = self.options;
	},
	refresh : function() {
		console.info(this.widgetName + '._refresh');
		var self = this, opts = self.options;
	},
	destroy : function() {
		console.info(this.widgetName + '.destroy');
		var self = this, opts = self.options, el = self.element;

		opts.layers.length = 0;
		$.Widget.prototype.destroy.call(this);
	}
});
