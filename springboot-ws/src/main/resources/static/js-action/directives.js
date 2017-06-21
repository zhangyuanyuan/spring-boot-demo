/**
 * Created by quanquan on 2017/6/21.
 */
actionApp.directive('datePicker', function () {
    return {
        restrict:'AC',
        link: function (scope, ele, attrs) {
            ele.datepicker();
        }
    }
})