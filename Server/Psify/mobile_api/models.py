from django.db import models

# Create your models here.

class Mood(models.Model):
	id_user = models.IntegerField(null=False) # pk
	time	= models.DateTimeField(null=False)
	comment = models.CharField(max_length=300, null=True)
	happy	= models.IntegerField(default=0)
	sad		= models.IntegerField(default=0)
	calm	= models.IntegerField(default=0)
	excited	= models.IntegerField(default=0)
	bored	= models.IntegerField(default=0)
	nervous	= models.IntegerField(default=0)
	tired	= models.IntegerField(default=0)
	scared	= models.IntegerField(default=0)
	angry	= models.IntegerField(default=0)

class Event(models.Model):
	id_user		= models.IntegerField(null=False) 
	time_start	= models.DateTimeField(null=False)
	time_end	= models.DateTimeField(null=True)
	questions	= models.CharField(max_length=1000, null=True)
	comment		= models.CharField(max_length=500, null=True)
	