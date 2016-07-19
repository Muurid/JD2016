<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<div class="form-group">
    <label class="col-md-4 control-label" for="electronics">Electronics</label>
        <div class="col-md-4">
            <input id="electronics" name="Electronics" type="text" value="electronics" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите electronics</span>
        </div>
</div>

<div class="form-group">
    <label class="col-md-4 control-label" for="manufacturer">Manufacturer</label>
        <div class="col-md-4">
            <input id="manufacturer" name="Manufacturer" type="text" value="manufacturer" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите name</span>
        </div>
</div>

<div class="form-group">
    <label class="col-md-4 control-label" for="name">Name</label>
        <div class="col-md-4">
            <input id="name" name="Name" type="text" value="name" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите name</span>
        </div>
</div>

<div class="form-group">
    <label class="col-md-4 control-label" for="model">Model</label>
        <div class="col-md-4">
            <input id="model" name="Model" type="text" value="model" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите name</span>
        </div>
</div>

<div class="form-group">
    <label class="col-md-4 control-label" for="price">Price</label>
        <div class="col-md-4">
            <input id="price" name="Price" type="text" value="3" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите цену</span>
        </div>
</div>

<div class="form-group">
    <label class="col-md-4 control-label" for="description">Description</label>
        <div class="col-md-4">
            <input id="description" name="Description" type="text" value="description" placeholder="" class="form-control input-md" required="">
            <span class="help-block">Укажите name</span>
        </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">OK</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
