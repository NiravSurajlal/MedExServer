from django.urls import path

from . import views

urlpatterns = [
    path('', views.home, name='home'),
    # path('register', views.register_user, name='register'),
    # path('login', views.login_view, name='login'),
    # path('logout', views.logout_view, name='logout'),
    path('create_quote', views.create_quote, name='create_quote'),

    path('signin', views.sign_in, name='signin'),
    path('signout', views.sign_out, name='signout'),
    path('callback', views.callback, name='callback'),
]