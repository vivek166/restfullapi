<!DOCTYPE html>
<html lang="en" ng-app="studentRecord">
<head>
  <title>Project</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <style>
    .row.content {height: 1500px}
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    header {
      background-color: #555;
      color: white;
      padding: 15px;
    }
  </style>
</head>
<body>
<header class="container-fluid">
<div class="row">
  <div class="col-sm-4">
    <p>PROJECT MANAGER</p>
  </div>
  <div class="col-sm-8">
    <div class="input-group">
       <input type="text" class="form-control" placeholder="Search Project..">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">
            Send
           </button>
          </span>
    </div>
  </div>
</div>
</header>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>HTTP METHODS</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#/">GET</a></li>
        <li><a href="#post">POST</a></li>
        <li><a href="#put">PUT</a></li>
        <li><a href="#delete">DELETE</a></li>
      </ul>
    </div>

    <div class="col-sm-9 sidenav">
        <div class="page-header">
<h2 id="table">Search student Record</h2>
</div>
<form class="form-inline">
<div class="form-group">
<label>search</label>
<input type="text" class="form-control" ng-model="search" placeholder="search">
</div>
</form>
<div class="bs-component" ng-controller="listdata">
<table class="table table-striped table-hover">
<thead>
  <tr>
    <th>Id</th>
    <th>first Name</th>
    <th>last name</th>
    <th>hobby</th>
  </tr>
</thead>
<tbody>
  <tr ng-repeat="user in users|filter:search">
  <td>{{user.id}}</td>
  <td>{{user.first_name}}</td>
  <td>{{user.last_name}}</td>
  <td>{{user.hobby}}</td>
  </tr>
</tbody>
</table>
</div>
</div>
</div>
</div>
<footer class="container-fluid">
  <p class="text-center">@all right reserved</p>
</footer>
<script src="studentApp.js"></script>
</body>
</html>
