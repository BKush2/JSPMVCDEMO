<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC_DAO_JSP_SERVLET</title>

    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">

    <!-- Custom CSS -->
    <style>
       .gradient-custom {
       /* fallback for old browsers */
       background: #f093fb;

       /* Chrome 10-25, Safari 5.1-6 */
       background: -webkit-linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1));

       /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
       background: linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1))
       }

       .card-registration .select-input.form-control[readonly]:not([disabled]) {
       font-size: 1rem;
       line-height: 2.15;
       padding-left: .75em;
       padding-right: .75em;
       }
       .card-registration .select-arrow {
       top: 13px;
       }
    </style>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
           <form action="ValidationFilter" method="post">
            <div style="color: red;">
                   ${requestScope.errorMessage}
               </div>
               <div class="row">
                   <div class="col-md-6 mb-4">
                       <div class="form-outline">
                           <input type="text" id="employee_firstname" name="employee_firstname" class="form-control form-control-lg" />
                           <label class="form-label" for="employee_firstname">First Name</label>
                       </div>
                   </div>
                   <div class="col-md-6 mb-4">
                       <div class="form-outline">
                           <input type="text" id="employee_lastname" name="employee_lastname" class="form-control form-control-lg" />
                           <label class="form-label" for="employee_lastname">Last Name</label>
                       </div>
                   </div>
               </div>

               <div class="row">
                   <div class="col-md-6 mb-4 d-flex align-items-center">
                       <div class="form-outline datepicker w-100">
                           <input type="text" id="employee_DOB" name="employee_DOB" class="form-control form-control-lg" />
                           <label class="form-label" for="employee_DOB">Birthday</label>
                       </div>
                   </div>
                   <div class="col-md-6 mb-4">
                       <h6 class="mb-2 pb-1">Gender: </h6>
                       <div class="form-check form-check-inline">
                           <input class="form-check-input" type="radio" id="employee_gender_female" name="employee_gender" value="Female" />
                           <label class="form-check-label" for="employee_gender_female">Female</label>
                       </div>
                       <div class="form-check form-check-inline">
                           <input class="form-check-input" type="radio" id="employee_gender_male" name="employee_gender" value="Male" />
                           <label class="form-check-label" for="employee_gender_male">Male</label>
                       </div>
                       <div class="form-check form-check-inline">
                           <input class="form-check-input" type="radio" id="employee_gender_other" name="employee_gender" value="Other" />
                           <label class="form-check-label" for="employee_gender_other">Other</label>
                       </div>
                   </div>
               </div>

               <div class="row">
                   <div class="col-md-6 mb-4 pb-2">
                       <div class="form-outline">
                           <input type="email" id="employee_email" name="employee_email" class="form-control form-control-lg" />
                           <label class="form-label" for="employee_email">Email</label>
                       </div>
                   </div>
                   <div class="col-md-6 mb-4 pb-2">
                       <div class="form-outline">
                           <input type="tel" id="employee_phoneno" name="employee_phoneno" class="form-control form-control-lg" />
                           <label class="form-label" for="employee_phoneno">Phone Number</label>
                       </div>
                   </div>
               </div>

               <div class="row">
                   <div class="col-12">
                       <select class="select form-control-lg" name="employee_subject">
                           <option value="Choose option">Choose option</option>
                           <option value="Java">Java</option>
                           <option value="JavaScript">JavaScript</option>
                           <option value="Python">Python</option>
                       </select>
                   </div>
               </div>

               <div class="mt-4 pt-2">
                   <input class="btn btn-primary btn-lg mx-4" type="submit" value="Submit" />
               </div>
           </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>