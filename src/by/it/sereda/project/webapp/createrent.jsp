<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATERENT" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Предложить номер</legend>

<!-- Textarea -->
<div class="form-group">
   <label class="col-md-4 control-label" for="Hotels">Наименование отеля</label>
   <div class="col-md-4">
      <textarea class="form-control" id="Hotels" name="Hotels">TEST: Метрополь Москва</textarea>
   </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="RoomCount">Количество комнат в номере</label>
  <div class="col-md-4">
    <label class="radio-inline" for="RoomCount-0">
      <input type="radio" name="RoomCount" id="RoomCount-0" value="1" >
      1
    </label>
    <label class="radio-inline" for="RoomCount-1">
      <input type="radio" name="RoomCount" id="RoomCount-1" value="2" checked="checked">
      2
    </label>
    <label class="radio-inline" for="RoomCount-2">
      <input type="radio" name="RoomCount" id="RoomCount-2" value="3">
      3
    </label>
    <label class="radio-inline" for="RoomCount-3">
      <input type="radio" name="RoomCount" id="RoomCount-3" value="4">
      4
    </label>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Address">Адрес</label>
  <div class="col-md-4">
  <input id="Address" name="Address" type="text" placeholder="" value="TEST: пр. Держинского, д.1, Минск, Беларусь" class="form-control input-md" required="">
  <span class="help-block">укажите адрес отеля</span>
  </div>
</div>

  <!-- Select Basic -->
  <div class="form-group">
    <label class="col-md-4 control-label" for="Guests">Количество гостей</label>
    <div class="col-md-2">
      <select id="Guests" name="Guests" class="form-control">
        <option value="1">1</option>
        <option selected value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
      </select>
    </div>
  </div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floor">Количество детей</label>
  <div class="col-md-2">
    <select id="Floor" name="Floor" class="form-control">
      <option value="1">1</option>
      <option selected value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      <option value="6">6</option>
      <option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
    </select>
  </div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Rating">Площадь</label>
  <div class="col-md-4">
  <input id="Rating" name="Rating" type="text" placeholder="" value="5" class="form-control input-md" required="">
  <span class="help-block">Оценка номера</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Цена</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" value="70" class="form-control input-md" required="">
  <span class="help-block">Укажите цену за ночь</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Готово</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
