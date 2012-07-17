<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <h2>Form Validation</h2>
        <script language = "Javascript">
          function checkEmail() {
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(form.email.value)){
            return true;
            }
            return false; 
          }
          function checkName(str){
              var re = /[^a-zA-Z]/g
              if (re.test(str)) return false;
              return true;
            }
            function checkAddress(str){
              var re = /[^[a-z][A-Z][0-9]]/g
              if(re.test(str)) return false;
              return true;
            }
          function validate(){
            var emailID=document.form.email;
              var nn=document.form.name;
                var add=document.form.address;

            if((nn.value==null)||(nn.value=="")){
            alert("Please Enter your Name!")
            nn.focus();
            return false
            }
            if(checkName(nn.value)==false){
            nn.value=""
            alert("Invalid Name!");
            nn.focus()
            return false
            }
            if((emailID.value==null)||(emailID.value=="")){
            alert("Please Enter your Email ID!")
            emailID.focus()
            return false
            }
            if (checkEmail(emailID.value)==false){
            emailID.value=""
            alert("Invalid Email Adderess!");
            emailID.focus()
            return false
            }
            if ((add.value==null)||(add.value=="")){
            alert("Please Enter your Address!")
            add.focus()
            return false
            }
            if (checkAddress(add.value)==false){
            add.value=""
            alert("Invalid Adderess!");
            add.focus()
            return false
            }
            if(document.form.qua.selectedIndex==""){
            alert ( "Please select your qualification!" );
     return false;  
    }
            return true
          }
        </script>
        <form name="form" method="post" onSubmit="return validate()">
        <pre>
        Enter Name:              <input type="text" name="name" size="30"><br>
        Enter an Email Address : <input type="text" name="email" size="30"><br>
        Enter Address            <textarea name="address" rows="5" cols="23"></textarea><br>
        Select Qualification:    <select name="qua">
                                 <option value="BTech">BTech</option>
                                 <option value="MBBS">MBBS</option>
                                 <option value="MBA">MBA</option>
                                 <option value="MCA">MCA</option>
                                 </select><br>

        <input type="submit" name="Submit" value="Submit">
        </pre>
        </form>
</html>