/**
 * Created by quanquan on 2017/6/21.
 */
actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http',
    function ($rootScope, $scope, $http) {
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成')
        });

        $scope.search = function () {
            var personName = $scope.personName;
            $http.get('search', {
                params: {personName: personName}
            }).success(function (data) {
                $scope.person = data;
            })
        }
    }
]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',
    function ($rootScope, $scope) {
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成')
        });

    }
]);