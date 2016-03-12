
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Nowaste.az</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/?action=about">About</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/?action=register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/?action=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>

    </div>
</nav>
<div id="filter-panel" class="collapse filter-panel">
    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-inline" role="form">
                <div class="form-group">
                    <label class="filter-col" style="margin-right:0;" >Price:</label>
                    <input type="text" class="form-control input-sm" id="search-price">

                    <label class="filter-col" style="margin-right:0;" >Amount:</label>
                    <input type="text" class="form-control input-sm" id="search-amount">

                    <label class="filter-col" style="margin-right:0;" >State:</label>
                    <input type="text" class="form-control input-sm" id="search-state">

                    <label class="filter-col" style="margin-right:0;" >City:</label>
                    <input type="text" class="form-control input-sm" id="search-city">

                </div><!-- form group [search] -->
                <div class="form-group">
                    <label class="filter-col" style="margin-top:10px;" for="pref-orderby">Type:</label>
                    <select id="pref-orderby" class="form-control">
                        <option>Chicken Meals</option>
                        <option> Beef Meals</option>
                        <option> Fish Meals</option>
                        <option> Lamb Meals</option>
                        <option> Pork Meals</option>
                        <option> Vegetarian Meals</option>
                    </select>
                </div> <!-- form group [order by] -->
                <%--<div class="form-group">--%>
                <%--<div class="checkbox" style="margin-left:10px; margin-right:10px;">--%>
                <%--<label><input type="checkbox"> Ingested</label>--%>
                <%--</div>--%>
                <%--<div class="checkbox" style="margin-left:10px; margin-right:10px;">--%>
                <%--<label><input type="checkbox"> Automated</label>--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-default filter-col">--%>
                <%--<span class="glyphicon glyphicon-record"></span> Save Settings--%>
                <%--</button>--%>
                <%--</div>--%>
            </form>
        </div>
    </div>
</div>

<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filter-panel">
    <span class="glyphicon glyphicon-cog"></span>Search
</button>


