document.write("<script language=javascript src='/resources/script/dictionary.js'></script>");
var bookappointment={
		//封装相关ajax的url
		URL:{
			appoint:function(bookId,studentId){
				return '/books/'+bookId+'/appoint?studentId='+studentId;
			},
			verifyStudent:function(){
				return '/books'+'/verifyStudent';
			},
			verifyAdmin:function () {
				return '/books'+'/verifyAdmin';
            },
			addBook:function () {
				return '/books'+'/add'
            },
            addBookData:function () {
                return '/books'+'/bookData'
            },
            IP:function () {
                return "http://localhost:8080";
            },
            bookList:function () {
				return "/books"+"/list"
            }
		},
		//验证学号和密码
		validateUser:function(userId, password, userType){
			console.log(userId + password + userType);
			if(!userId||!password){
				return "nothing";
			}else {
				if(bookappointment.verifyWithDatabase(userId, password,userType)){
					return "success";
				}else{
					return "mismatch";
				}
			}  
		},
		//将学号和用户名与数据库匹配
		verifyWithDatabase:function(userId, password, userType){
			var result=false;
			var params={};
			var verifyUrl = '';
			params.userId=userId;
			params.password=password;
			console.log("params.studentId:"+params.userId);
			console.log("params.password:"+params.password);
			if(userType == "student"){
				verifyUrl = bookappointment.URL.verifyStudent();
			}else if(userType == "admin"){
				verifyUrl = bookappointment.URL.verifyAdmin();
			}
			$.ajax({
				type:'post',
				url:verifyUrl,
				data:params,
				datatype:'json',
				async:false,                       //同步调用，保证先执行result=true,后再执行return result;
				success:function(data){
					if(data.result=='SUCCESS'){
						window.location.reload();
						alert("登陆成功！");
						result=true;
					}else{
						result=false;
					}
				}
			});
			console.log("我是验证结果："+result);
			return result;
		},
        //书籍列表页面
		list:{
		    //跳转添加书籍页面
		    toAddPage:function(){
			var addUrl = bookappointment.URL.addBook();
			window.location.href = bookappointment.URL.IP()+addUrl;
            },
		    init:function () {
		    	//console.log($.cookie('userType'));
                $('#addBook').click(function () {
                        bookappointment.list.toAddPage();
                    });
            }
        },
        //添加书籍页面
        addBookPage:{
		    init:function () {
		    	console.log("添加页面初始化！");
                $('#addBtn').click(function () {
                    bookappointment.addBookPage.addBook();
                });
            },
			validateBook:function (bookId, bookName, bookIntrod, bookNumber) {
				console.log("书籍信息校验启动---");
				var dic = new Dictionary();
				// 规定各项参数为必填参数
				//规定书本ID为4位数
				//规定书籍数量不得大于100
				if(!bookId || !bookName || !bookIntrod || !bookNumber){
					dic.set("1", "existing Null value");
					return "1";
				}
				else if(bookId.length != 4){
					dic.set("2", "bookId's length must be 4");
					return "2";
				}
				else if(bookNumber > 100){
					dic.set("3", "bookNumber must less than 100");
					return "3";
				}
				else {
					dic.set("4", "validate success!");
					return "4";
				}
			},
		    addBook:function () {
		    	//模态框 对用户添加行为的响应
		    	var addResultModel = $('#addResultModel');
                var bookId = $('#bookIdKey').val();
                var bookName = $('#bookNameKey').val();
                var bookIntrod = $('#bookIntrodKey').val();
                var bookNumber = $('#bookNumberKey').val();
                var validate = bookappointment.addBookPage.validateBook(bookId, bookName, bookIntrod, bookNumber);
                if(validate == "1"){
                	$('#addMessage').hide().html('<label class="label label-danger">不能有空值!</label>').show(300);
				}else if(validate == "2"){
                	$('#addMessage').hide().html('<label class="label label-danger">书籍的ID必须为4位数!</label>').show(300);
				}else if(validate == "3"){
                	$('#addMessage').hide().html('<label class="label label-danger">书籍的数量不能大于100!</label>').show(300);
				}else if(validate == "4"){
					console.log(bookId, bookName, bookIntrod, bookNumber);
                	var params = {};
                	var bookDataUrl = bookappointment.URL.addBookData();
                	params['bookId'] = bookId;
               	 	params['bookName'] = bookName;
                	params['bookIntrod'] = bookIntrod;
                	params['bookNumber'] = bookNumber;
                	$.ajax({
                    	type: 'get',
                    	url: bookDataUrl,
						data: params,
						async: false,
						success:function (result) {
                    		if(result == "success"){
                    			$('#resultMessage').text("书籍添加成功！");
                    			addResultModel.modal({
								show: true,//显示弹出层
	                    		backdrop: 'static',//禁止位置关闭
	                    		keyboard: false//关闭键盘事件
								});
							}else if(result == "failed"){
                    			$('#resultMessage').text("书籍添加失败！存在相同的书籍ID");
                    			addResultModel.modal({
								show: true,//显示弹出层
	                    		backdrop: 'static',//禁止位置关闭
	                    		keyboard: false//关闭键盘事件
								});
							}
						}
                	});
				}
			}
        },
		//预定图书逻辑
		detail:{
			//预定也初始化
			init:function(params){
				var bookId=params['bookId']; 
				console.log("页面详情初始化--");
				var userId=$.cookie('userId');
				var password=$.cookie('password');
				console.log(userId, password, "---",$.cookie('userType'));
				var userType = '';
				if(!userId||!password){
					//设置弹出层属性
					var chooseModel=$('#chooseModel');
					var userModel = $('#userModel');
					chooseModel.modal({
						show: true,//显示弹出层
	                    backdrop: 'static',//禁止位置关闭
	                    keyboard: false//关闭键盘事件
					});
					$('#studentLogin').click(function () {
						userModel.modal({
							show: true,//显示弹出层
	                    	backdrop: 'static',//禁止位置关闭
	                    	keyboard: false//关闭键盘事件
						});
						userType = 'student';
                    });
					$('#adminLogin').click(function () {
						userModel.modal({
							show: true,//显示弹出层
	                    	backdrop: 'static',//禁止位置关闭
	                    	keyboard: false//关闭键盘事件
						});
						userType = 'admin';
                    });
					$('#userBtn').click(function (){
						if(userType == 'student'){
							bookappointment.detail.userLogin(userId, password, userType);
						}else if(userType == 'admin'){
							bookappointment.detail.userLogin(userId, password, userType);
						}
					});
				}else{
					var appointbox=$('#appoint-box');
					bookappointment.appointment(bookId,userId,appointbox);
				} 
			},
			userLogin:function (userId, password, userType) {
				userId=$('#userIdKey').val();
				password=$('#passwordKey').val();
				//调用validateStudent函数验证用户id和密码。
				var temp=bookappointment.validateUser(userId, password, userType);
				console.log(temp);
				if(temp=="nothing"){
					console.log("显示label");
					$('#userMessage').html('<label class="label label-danger">帐号或密码为空!</label>').show();
					setTimeout(function () {
						$('#userMessage').hide();
                    }, 1000);
				}else if(temp=="mismatch"){
					$('#userMessage').html('<label class="label label-danger">帐号密码不匹配!</label>').show();
					setTimeout(function () {
						$('#userMessage').hide();
                    }, 1000);
				}else if(temp=="success"){
					//学号与密码匹配正确，将学号密码保存在cookie中。不设置cookie过期时间，这样即为session模式，关闭浏览器就不保存密码了。
					$.cookie('userId', userId, {  path: '/books'});
					$.cookie('password', password, {  path: '/books'});
					$.cookie('userType', userType, { path: '/books'});
				}
			},
		},
		appointment:function(bookId,studentId, node){
			console.log("执行预约的方法!" );
			node.html('<button class="btn btn-primary btn-lg" id="appointmentBtn">预约</button>');
			  
			var appointmentUrl = bookappointment.URL.appoint(bookId,studentId);
			console.log("appointmentUrl:"+appointmentUrl);
			//绑定一次点击事件
			$('#appointmentBtn').one('click', function () {
				//执行预约请求
				//1、先禁用请求
				$(this).addClass('disabled');
				//2、发送预约请求执行预约
				$.post(appointmentUrl,{},function(result){   //Ajax强大之处，向Controller方法提出请求和返回结果在一处!
					if(result && result['success']){         //同时还可以连续取对象的子对象！
						var appointResult=result['data'];
							console.log("appointResult"+appointResult);
						var state=appointResult['state'];
							console.log("state"+state);
						var stateInfo=appointResult['stateInfo'];
							console.log("stateInfo"+stateInfo);
						//显示预约结果                                                          把结果显示给页面，完成了jsp的工作
							 
						node.html('<span class="label label-success">'+stateInfo+'</span>');
					}       //因为公用一个node所以，用来显示“stateInfo”时就不会显示上面的“预约”
					console.log('result'+result);
				});
			 });
			
			
		}
};
