<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать новое объявление</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Brand">Марка</label>
  <div class="col-md-4">
  <input id="Brand" name="Brand" type="text" placeholder="Введите марку автомобиля" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Model">Модель</label>
  <div class="col-md-4">
  <input id="Model" name="Model" type="text" placeholder="Введите модель" class="form-control input-md" required="">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Year">Год выпуска</label>
  <div class="col-md-2">
    <select id="Year" name="Year" class="form-control">
      <option value="1960">1960</option>
      <option value="1961">1961</option>
      <option value="1962">1962</option>
      <option value="1963">1963</option>
      <option value="1964">1964</option>
      <option value="1965">1965</option>
      <option value="1966">1966</option>
      <option value="1967">1967</option>
      <option value="1968">1968</option>
      <option value="1969">1969</option>
      <option value="1970">1970</option>
      <option value="1971">1971</option>
      <option value="1972">1972</option>
      <option value="1973">1973</option>
      <option value="1974">1974</option>
      <option value="1975">1975</option>
      <option value="1976">1976</option>
      <option value="1977">1977</option>
      <option value="1978">1978</option>
      <option value="1979">1979</option>
      <option value="1980">1980</option>
      <option value="1981">1981</option>
      <option value="1982">1982</option>
      <option value="1983">1983</option>
      <option value="1984">1984</option>
      <option value="1985">1985</option>
      <option value="1986">1986</option>
      <option value="1987">1987</option>
      <option value="1988">1988</option>
      <option value="1989">1989</option>
      <option value="1990">1990</option>
      <option value="1991">1991</option>
      <option value="1992">1992</option>
      <option value="1993">1993</option>
      <option value="1994">1994</option>
      <option value="1995">1995</option>
      <option value="1996">1996</option>
      <option value="1997">1997</option>
      <option value="1998">1998</option>
      <option value="1999">1999</option>
      <option value="2000">2000</option>
      <option value="2001">2001</option>
      <option value="2002">2002</option>
      <option value="2003">2003</option>
      <option value="2004">2004</option>
      <option value="2005">2005</option>
      <option value="2006">2006</option>
      <option value="2007">2007</option>
      <option value="2008">2008</option>
      <option value="2009">2009</option>
      <option value="2010">2010</option>
      <option value="2011">2011</option>
      <option value="2012">2012</option>
      <option value="2013">2013</option>
      <option value="2014">2014</option>
      <option value="2015">2015</option>
      <option value="2016">2016</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Type">Тип кузова</label>
  <div class="col-md-2">
    <select id="Type" name="Type" class="form-control">
      <option value="sedan">sedan</option>
      <option value="avant">avant</option>
      <option value="hatchback">hatchback</option>
      <option value="cabrio">cabrio</option>
      <option value="miniven">miniven</option>
      <option value="cross">cross</option>
      <option value="coupe">coupe</option>
      <option value="">вседорожный</option>
    </select>
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Transmission">Тип трансмиссии</label>
  <div class="col-md-4">
    <label class="radio-inline" for="Transmission-0">
      <input type="radio" name="Transmission" id="Transmission-0" value="manual" checked="checked">
      manual
    </label>
    <label class="radio-inline" for="Transmission-1">
      <input type="radio" name="Transmission" id="Transmission-1" value="automatic">
      automatic
    </label>
    <label class="radio-inline" for="Transmission-2">
      <input type="radio" name="Transmission" id="Transmission-2" value="robot">
      robot
    </label>
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Engine">Тип двигателя</label>
  <div class="col-md-4">
    <label class="radio-inline" for="Engine-0">
      <input type="radio" name="Engine" id="Engine-0" value="Petrol" checked="checked">
      Petrol
    </label>
    <label class="radio-inline" for="Engine-1">
      <input type="radio" name="Engine" id="Engine-1" value="Diesel">
      Diesel
    </label>
    <label class="radio-inline" for="Engine-2">
      <input type="radio" name="Engine" id="Engine-2" value="Gas/Petrol">
      Gas/Petrol
    </label>
    <label class="radio-inline" for="Engine-3">
      <input type="radio" name="Engine" id="Engine-3" value="Hybrid">
      Hybrid
    </label>
    <label class="radio-inline" for="Engine-4">
      <input type="radio" name="Engine" id="Engine-4" value="E-tronic">
      E-tronic
    </label>
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Drive_unit">Привод</label>
  <div class="col-md-4">
    <label class="radio-inline" for="Drive_unit-0">
      <input type="radio" name="Drive_unit" id="Drive_unit-0" value="Front" checked="checked">
      Front
    </label>
    <label class="radio-inline" for="Drive_unit-1">
      <input type="radio" name="Drive_unit" id="Drive_unit-1" value="Rear">
      Rear
    </label>
    <label class="radio-inline" for="Drive_unit-2">
      <input type="radio" name="Drive_unit" id="Drive_unit-2" value="All">
      All
    </label>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Mileage">Пробег</label>
  <div class="col-md-2">
  <input id="Mileage" name="Mileage" type="text" placeholder="Введите пробег" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Color">Цвет</label>
  <div class="col-md-2">
  <input id="Color" name="Color" type="text" placeholder="Введите цвет" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Цена</label>
  <div class="col-md-2">
  <input id="Price" name="Price" type="text" placeholder="Введите стоимость" class="form-control input-md" required="">
  <span class="help-block">Цена в USD</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Создать</button>
  </div>
</div>

</fieldset>
</form>




<%@ include file="include/end-html.jsp" %>
