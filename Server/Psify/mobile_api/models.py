from django.db import models
# Create your models here.

class Mood(models.Model):
	id_user = models.IntegerField(null=False) # pk user to pacjent
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
	time_start	= models.DateTimeField(null=True)
	time_end	= models.DateTimeField(null=True)
	questions	= models.CharField(max_length=1000, null=True)
	comment		= models.CharField(max_length=500, null=True)
	
class User(models.Model):
	id_user		= models.AutoField(primary_key=True)
	id_doctor	= models.IntegerField(null=True) #fk
	name		= models.CharField(max_length=50)
	surname		= models.CharField(max_length=50)
	phone		= models.IntegerField()
	email		= models.CharField(max_length=50)
	password	= models.CharField(max_length=12)
	notes		= models.CharField(max_length=3000, null=True)
	diagnosis	= models.CharField(max_length=300, null=True)
	achtung		= models.BooleanField(default=False)	# czy ostatnio zdarzył się atak

