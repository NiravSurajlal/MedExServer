"""
Defines all of the urls acessible in this module.
"""

from django.urls import path

from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('create_quote', views.create_quote, name='create_quote'),
    path('selector', views.selector, name='selector'),
    path('view_queue', views.view_queue, name='view_queue'),

    path('signin', views.sign_in, name='signin'),
    path('signout', views.sign_out, name='signout'),
    path('callback', views.callback, name='callback'),
]
