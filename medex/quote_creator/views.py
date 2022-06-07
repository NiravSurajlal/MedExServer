from django.http import HttpResponse

# Create your views here.

def index(reuqest):
    return HttpResponse('Hello Worlds. At Index. ')
