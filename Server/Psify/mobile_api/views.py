from django.shortcuts import render
from rest_framework import viewsets, generics
from .models import Mood, Event
from .serializers import MoodSerializer, EventSerializer


class MoodListCreateView(generics.ListCreateAPIView):
    queryset = Mood.objects.all()
    serializer_class = MoodSerializer

class EventListCreateView(generics.ListCreateAPIView):
	queryset = Event.objects.all()
	serializer_class = EventSerializer