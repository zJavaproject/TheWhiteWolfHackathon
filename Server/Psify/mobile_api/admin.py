from django.contrib import admin
from .models import User, Mood, Event
# Register your models here.
admin.site.register(User)
admin.site.register(Mood)
admin.site.register(Event)
