--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.0
-- Dumped by pg_dump version 9.5.0

-- Started on 2016-03-20 22:00:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 190 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 190
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16861)
-- Name: benutzer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE benutzer (
    user_id integer NOT NULL,
    mitarbeiter boolean NOT NULL,
    user_name character varying(30) NOT NULL,
    v_name character varying(30) NOT NULL,
    n_name character varying(30) NOT NULL,
    email text NOT NULL,
    passwort character varying(30) NOT NULL
);


ALTER TABLE benutzer OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16859)
-- Name: benutzer_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE benutzer_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE benutzer_user_id_seq OWNER TO postgres;

--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 184
-- Name: benutzer_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE benutzer_user_id_seq OWNED BY benutzer.user_id;


--
-- TOC entry 189 (class 1259 OID 16910)
-- Name: bewertungen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE bewertungen (
    serie_id smallint NOT NULL,
    bewertung numeric(3,1),
    anzahl_1 smallint,
    anzahl_2 smallint,
    anzahl_3 smallint,
    anzahl_4 smallint,
    anzahl_5 smallint,
    anzahl_6 smallint,
    anzahl_7 smallint,
    anzahl_8 smallint,
    anzahl_9 smallint,
    anzahl_10 smallint,
    CONSTRAINT gueltige_bewertung CHECK (((bewertung >= 0.0) AND (bewertung <= 10.0)))
);


ALTER TABLE bewertungen OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16891)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE comments (
    comment_id integer NOT NULL,
    user_id smallint NOT NULL,
    serie_id smallint NOT NULL,
    comment_text text NOT NULL
);


ALTER TABLE comments OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16889)
-- Name: comments_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE comments_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_comment_id_seq OWNER TO postgres;

--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 187
-- Name: comments_comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE comments_comment_id_seq OWNED BY comments.comment_id;


--
-- TOC entry 186 (class 1259 OID 16876)
-- Name: favorites; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE favorites (
    user_id smallint NOT NULL,
    serie_id smallint NOT NULL
);


ALTER TABLE favorites OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16848)
-- Name: schauspieler; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE schauspieler (
    person_id integer NOT NULL,
    name character varying(30) NOT NULL,
    serie_id smallint NOT NULL
);


ALTER TABLE schauspieler OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16846)
-- Name: schauspieler_person_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE schauspieler_person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE schauspieler_person_id_seq OWNER TO postgres;

--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 182
-- Name: schauspieler_person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE schauspieler_person_id_seq OWNED BY schauspieler.person_id;


--
-- TOC entry 181 (class 1259 OID 16823)
-- Name: serie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE serie (
    serie_id integer NOT NULL,
    serie_name character varying(40) NOT NULL,
    beschreibung character varying(200) NOT NULL,
    fsk smallint NOT NULL,
    genre1 character varying(30) NOT NULL,
    genre2 character varying(30),
    genre3 character varying(30),
    sendetag text NOT NULL
);


ALTER TABLE serie OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16821)
-- Name: serie_serie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE serie_serie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE serie_serie_id_seq OWNER TO postgres;

--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 180
-- Name: serie_serie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE serie_serie_id_seq OWNED BY serie.serie_id;


--
-- TOC entry 2012 (class 2604 OID 16864)
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benutzer ALTER COLUMN user_id SET DEFAULT nextval('benutzer_user_id_seq'::regclass);


--
-- TOC entry 2013 (class 2604 OID 16894)
-- Name: comment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comments ALTER COLUMN comment_id SET DEFAULT nextval('comments_comment_id_seq'::regclass);


--
-- TOC entry 2011 (class 2604 OID 16851)
-- Name: person_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY schauspieler ALTER COLUMN person_id SET DEFAULT nextval('schauspieler_person_id_seq'::regclass);


--
-- TOC entry 2010 (class 2604 OID 16826)
-- Name: serie_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY serie ALTER COLUMN serie_id SET DEFAULT nextval('serie_serie_id_seq'::regclass);


--
-- TOC entry 2155 (class 0 OID 16861)
-- Dependencies: 185
-- Data for Name: benutzer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY benutzer (user_id, mitarbeiter, user_name, v_name, n_name, email, passwort) FROM stdin;
10	f	regpwtest	reg	pwtest	pwtest@huhu.de	hCdwNMSXM84iltolM1vMJA==
5	f	MingLee	copy	pasterino	emailtest@web.de	TUemKI1ESRSmFHL+gdgXEA==
7	f	TestBenutzer	Max	Mustermann	maxm@max.de	DNEP62krF6rwZGH65v+65w==
1	t	AriGold	Marcel	Sievert	sievertm@uni-hildesheim.de	SgiUGQ8jZu4KjXvuylJW7A==
2	t	Hassib	Said Hassib	Sadat	sadats@uni-hildesheim.de	SgiUGQ8jZu4KjXvuylJW7A==
3	t	Daniel	Daniel	Weniger	weniger@uni-hildesheim.de	SgiUGQ8jZu4KjXvuylJW7A==
9	t	testadmin	test	admin	testadmin@uni-hildesheim.de	x4rs4pXFRq8FiPKr3Okm3A==
8	f	EazPeaz	Mr	Sir	mr.sir@uni.hildesheim.de	Se4XX9mpeEpTFRR2SvqSWQ==
\.


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 184
-- Name: benutzer_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('benutzer_user_id_seq', 10, true);


--
-- TOC entry 2159 (class 0 OID 16910)
-- Dependencies: 189
-- Data for Name: bewertungen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bewertungen (serie_id, bewertung, anzahl_1, anzahl_2, anzahl_3, anzahl_4, anzahl_5, anzahl_6, anzahl_7, anzahl_8, anzahl_9, anzahl_10) FROM stdin;
1	7.0	0	0	0	0	3	4	2	5	1	1
3	0.0	0	0	0	0	0	0	0	0	0	0
4	6.4	6	2	7	10	20	11	44	23	7	9
5	0.0	0	0	0	0	0	0	0	0	0	0
6	0.0	0	0	0	0	0	0	0	0	0	0
7	0.0	0	0	0	0	0	0	0	0	0	0
8	0.0	0	0	0	0	0	0	0	0	0	0
2	0.0	0	0	0	0	0	0	1	0	0	0
\.


--
-- TOC entry 2158 (class 0 OID 16891)
-- Dependencies: 188
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY comments (comment_id, user_id, serie_id, comment_text) FROM stdin;
1	1	3	First! :)
2	2	3	Ich nicht :(
3	3	3	Ich auch net :(
4	1	1	Super Serie
5	2	2	Finde ich gut
6	3	1	Spitze
7	3	2	Der H-A-Doppel M-E-R
8	2	6	Finde ich gut
9	3	8	Spitze
10	3	4	Der H-A-Doppel M-E-R
\.


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 187
-- Name: comments_comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('comments_comment_id_seq', 10, true);


--
-- TOC entry 2156 (class 0 OID 16876)
-- Dependencies: 186
-- Data for Name: favorites; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY favorites (user_id, serie_id) FROM stdin;
1	1
1	2
1	4
1	5
1	6
1	7
1	8
2	1
2	2
2	5
2	8
3	1
3	3
3	4
3	5
3	7
3	8
5	1
5	2
5	4
5	6
5	7
5	5
5	3
5	8
10	4
10	2
\.


--
-- TOC entry 2153 (class 0 OID 16848)
-- Dependencies: 183
-- Data for Name: schauspieler; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY schauspieler (person_id, name, serie_id) FROM stdin;
1	Sullivan Stapleton	4
2	Jaimie Alexander	4
3	Rob Brown	4
4	Audrey Esparza	4
5	Ashley Johnson	4
6	Ukweli Roach	4
7	Marianne Jean-Baptiste	4
8	CJ Parson	4
9	Jared Padalecki	5
10	Jensen Ackles	5
11	Misha Collins	5
12	Jim Beaver	5
13	Mark Sheppard	5
14	Jake McDorman	6
15	Jennifer Carpenter	6
16	Hill Harper	6
17	Mary Elizabeth Mastrantonio	6
18	Tom Degnan	6
19	Michael James Shaw	6
20	Colin Salmon	6
21	Ron Rifkin	6
22	Eliza Taylor	7
23	Paige Turco	7
24	Bob Morley	7
25	Marie Avgeropoulos	7
26	Devon Bostick	7
27	Christopher Larkin	7
28	Isaiah Washington	7
29	Henry Ian Cusick	7
30	Lindsey Morgan	7
31	Ricky Whittle	7
32	Richard Harmon	7
33	Jarod Joseph	7
34	Thomas McDonell	7
35	Sachin Sahel	7
36	Adina Porter	7
37	Stephen Amell	8
38	Emily Bett Rickards	8
39	Katie Cassidy	8
40	Willa Holland	8
41	David Ramsey	8
42	Colton Haynes	8
43	Paul Blackthorne	8
44	John Barrowman	8
45	Susanna Thompson	8
46	Manu Bennett	8
47	Tom Ellis	1
48	Lauren German	1
49	Kevin Alejandro	1
50	Lesley-Ann Brandt	1
51	D.B. Woodside	1
52	Rachael Harris	1
53	Scarlett Estevez	1
54	Gabriel Macht	2
55	Patrick J. Adams	2
56	Rick Hoffman	2
57	Meghan Markle	2
58	Sarah Rafferty	2
59	Gina Torres	2
60	Johnny Galecki	3
61	Jim Parsons	3
62	Kaley Cuoco	3
63	Simon Helberg	3
64	Kunal Nayyar	3
65	Melissa Rauch	3
66	Mayim Bialik	3
\.


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 182
-- Name: schauspieler_person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('schauspieler_person_id_seq', 66, true);


--
-- TOC entry 2151 (class 0 OID 16823)
-- Dependencies: 181
-- Data for Name: serie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY serie (serie_id, serie_name, beschreibung, fsk, genre1, genre2, genre3, sendetag) FROM stdin;
2	Suits	Der geniale College-Abbrecher Mike Ross gibt sich als Anwalt aus.	12	Drama	Comedy		Donnerstag
4	Blindspot	Eine unbekannte Frau ohne Erinnerung versucht mit den Tattoos auf ihrem Körper rauszufinden wer sie ist.	16	Crime	Mystery	Action	Dienstag
5	Supernatural	2 Brüder gegen Dämonen und andere Monster.	16	Drama	Action	Fantasy	Donnerstag
6	Limitless	Die Droge NZT erweitert Brian Sinclairs Bewusstsein und ist dem FBI damit eine große Hilfe.	16	Drama	Crime	Thriller	Mittwoch
7	The 100	97 Jahre nach einem Atomkrieg versuchen 100 Jugendliche herauszufinden, ob die Erde wieder bewohnbar ist.	16	Science-Fiction	Action		Freitag
8	Arrow	Fünf Jahre auf einer einsamen Insel bringen Oliver Queen dazu in Starling City für Gerechtigkeit zu sorgen.	16	Drama	Action		Donnerstag
3	The Big Bang Theory	4 Nerds treffen auf die hübsche Blondine Penny.	12	Comedy	Fantasy		Donnerstag
1	Lucifer	Der Teufel nimmt sich Urlaub und hilft dem LAPD.	16	Fantasy	Comedy	Crime	Montag
\.


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 180
-- Name: serie_serie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('serie_serie_id_seq', 11, true);


--
-- TOC entry 2020 (class 2606 OID 16871)
-- Name: benutzer_eindeutig; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT benutzer_eindeutig UNIQUE (user_id);


--
-- TOC entry 2022 (class 2606 OID 16875)
-- Name: benutzer_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT benutzer_email_key UNIQUE (email);


--
-- TOC entry 2024 (class 2606 OID 16873)
-- Name: benutzer_user_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT benutzer_user_name_key UNIQUE (user_name);


--
-- TOC entry 2028 (class 2606 OID 16899)
-- Name: comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);


--
-- TOC entry 2018 (class 2606 OID 16853)
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY schauspieler
    ADD CONSTRAINT person_pkey PRIMARY KEY (person_id);


--
-- TOC entry 2016 (class 2606 OID 16831)
-- Name: serie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY serie
    ADD CONSTRAINT serie_pkey PRIMARY KEY (serie_id);


--
-- TOC entry 2026 (class 2606 OID 16869)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id, user_name);


--
-- TOC entry 2034 (class 2606 OID 16914)
-- Name: bewertungen_serie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bewertungen
    ADD CONSTRAINT bewertungen_serie_id_fkey FOREIGN KEY (serie_id) REFERENCES serie(serie_id);


--
-- TOC entry 2033 (class 2606 OID 16905)
-- Name: comments_serie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_serie_id_fkey FOREIGN KEY (serie_id) REFERENCES serie(serie_id);


--
-- TOC entry 2032 (class 2606 OID 16900)
-- Name: comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES benutzer(user_id);


--
-- TOC entry 2029 (class 2606 OID 16854)
-- Name: f_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY schauspieler
    ADD CONSTRAINT f_key FOREIGN KEY (serie_id) REFERENCES serie(serie_id);


--
-- TOC entry 2035 (class 2606 OID 16919)
-- Name: f_key; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bewertungen
    ADD CONSTRAINT f_key FOREIGN KEY (serie_id) REFERENCES serie(serie_id);


--
-- TOC entry 2031 (class 2606 OID 16884)
-- Name: favorites_serie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY favorites
    ADD CONSTRAINT favorites_serie_id_fkey FOREIGN KEY (serie_id) REFERENCES serie(serie_id);


--
-- TOC entry 2030 (class 2606 OID 16879)
-- Name: favorites_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY favorites
    ADD CONSTRAINT favorites_user_id_fkey FOREIGN KEY (user_id) REFERENCES benutzer(user_id);


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-20 22:00:20

--
-- PostgreSQL database dump complete
--

