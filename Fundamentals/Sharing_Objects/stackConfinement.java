// stack confinement
// 	a special case of thread confinement in which an object
// 	can only be reached through local variables

//thread confinement of local primitive and reference variables
public int loadTheArk(Collection<Animal> conidates)
{
	SortedSet<Animal> animals;

	int numPairs = 0;

	Animal canidate = null;

	// animals confined to method, don't let them escape!
	
	animals = new TreeSet<Animal>(new SpeciesGenderComparator() );
	animals.addAll(canidates);

	for( Animal a : animals)
	{
		if(canidate == null || !canidate.isPotentialMate(a))
		{
			canidate = a;
		}

		else
		{
			ark.load(new AnimalPair(canidate, a));
			++numPairs;
			canidate = null;
		}
	}
	return numPairs;
}
