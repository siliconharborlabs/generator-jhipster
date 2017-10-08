<%#
 Copyright 2013-2017 the original author or authors from the StackStack project.

 This file is part of the StackStack project, see http://stackstack.io/
 for more information.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-%>
(function() {
    'use strict';

    angular
        .module('<%=angularAppName%>', [
            'ngStorage',<% if (enableTranslation) { %>
            'tmh.dynamicLocale',
            'pascalprecht.translate',<% } %>
            'ngResource',
            'ngCookies',
            'ngAria',
            'ngCacheBuster',
            'ngFileUpload',
            'ui.bootstrap',
            'ui.bootstrap.datetimepicker',
            'ui.router',
            'infinite-scroll',
            // jhipster-needle-angularjs-add-module StackStack will add new module here
            'angular-loading-bar'
        ])
        .run(run);

    run.$inject = ['stateHandler'<% if (enableTranslation) { %>, 'translationHandler'<% } %>];

    function run(stateHandler<% if (enableTranslation) { %>, translationHandler<% } %>) {
        stateHandler.initialize();<% if (enableTranslation) { %>
        translationHandler.initialize();<% } %>
    }
})();
