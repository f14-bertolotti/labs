
venv/bin/activate: ./requirements.txt
	python3 -m venv venv
	venv/bin/python3 -m pip install -r requirements.txt

run-python: venv/bin/activate
	venv/bin/python3 -m jupyter lab ./Python

run-spark: venv/bin/activate
	venv/bin/python3 -m jupyter lab ./Spark

run-page-rank: venv/bin/activate
	venv/bin/python3 -m jupyter lab ./PageRank

run-deep-learning: venv/bin/activate
	venv/bin/python3 -m jupyter lab ./DeepLearning

run-recommendation-system: venv/bin/activate
	venv/bin/python3 -m jupyter lab ./RecommendationSystems

clean:
	rm -rf venv
