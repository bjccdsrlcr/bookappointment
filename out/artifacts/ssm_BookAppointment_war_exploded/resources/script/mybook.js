function validateStudent(studentId, password) {
        console.log("studentId:" + studentId);
        console.log("password:" + password);

        if(!studentId || !password){
            return 'nothing';
        }else if(studentId.length!=10 ||isNaN(studentId)||password.length!=6 ||isNaN(password)){
            return 'typeError';
        }else {
            if(verifyWithDatabase()){
                console.log("验证成功!");
                return "success";
            }else{
                console.log("验证失败");
                return "failed";
            }
        }
}

function verifyWithDatabase(studentId, password) {
        var result = false;
        var params = {};
        params.studentId = studentId;
        params.password = password;

        console.log("params.studentId:" + params.studentId);
        console.log("params.password:" + params.password);

        var url = '/books' + '/verify';
        $.ajax({
            type: 'post',
            url: url,
            data: params,
            datatype: 'json',
            async: false,
            success:function (data) {
                if(data.result=='SUCCESS'){
                    window.location.reload();
                    alert("登录成功");
                    result = true;
                }else{
                    result = false;
                }
            }
        });
        console.log("result" + result);
        return result;
}

function init(params) {
    var bookId = params['bookId'];
    console.log("jsjsjs");
    var studentId = $.cookie(studentId);
    var password = $.cookie(password);
    if(!studentId || !password){
        var loginModel = $('varifyModal');
        loginModel.modal({
            show: true,
            backdrop: 'static',
            keyboard: false
        });
        $('studentBtn').click(function () {
            studentId = $('studentIdKey').val();
            password = $('passwordKey').val();
            console.log("studentId:" + studentId + "\t password:" + password);
            var temp = validateStudent(studentId, password);
            console.log("temp: " + temp);
            if(temp=='nothing'){
                $('#studentMessage').hide().html('<label class="label label-danger">学号或密码为空!</label>').show(300);
            }else if(temp=="typeError"){
                $('#studentMessage').hide().html('<label class="label label-danger">格式不正确!</label>').show(300);
            }else if(temp=="mismatch") {
                $('#studentMessage').hide().html('<label class="label label-danger">学号密码不匹配!</label>').show(300);
            }else if(temp=='success'){

            }
        })
    }

}